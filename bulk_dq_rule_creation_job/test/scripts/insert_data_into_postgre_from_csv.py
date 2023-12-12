import csv
import io

import pandas as pd
import psycopg2

from bulk_dq_rule_creation_job.src.resources.constants import *


def jdbc_connection():
    host = os.environ['host']
    user = os.environ['user']
    port = os.environ['port']
    password = os.environ['password']
    database = os.environ['database']
    conn = psycopg2.connect(host=host, user=user, password=password, database=database)
    conn.autocommit = True
    return conn


def insert_into_db(table, df):
    _db_columns = db_columns[table]
    _df_columns = df_columns[table]
    conn = jdbc_connection()
    csv_buffer = io.StringIO()
    writer = csv.writer(csv_buffer)
    for index, row in df.iterrows():
        record = [row[i] for i in _df_columns]
        writer.writerow(record)

    csv_buffer.seek(0)

    with conn.cursor() as cur:
        postgres_insert_query = f"COPY {table} ({_db_columns}) FROM STDIN WITH(FORMAT CSV, DELIMITER ',',NULL '')"
        cur.copy_expert(postgres_insert_query, csv_buffer)

def insert_with_csv():
    home = 'C:\\Users\\Daidipya\\PycharmProjects\\data-quality-batch\\bulk_dq_rule_creation_job\\test\data\\dq_metadata_csv\\'
    table_array = ['rule_template','rule_template_properties','entity_template','entity_template_properties','entity','entity_properties','ruleset','rule','rule_entity_map','rule_properties']
    for entry in table_array:
        df = pd.read_csv(home+entry+'.csv')
        insert_into_db(entry,df)
        print('completed for entry',entry)

insert_with_csv()




