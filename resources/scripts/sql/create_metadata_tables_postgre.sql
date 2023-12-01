CREATE TABLE rule_template
(
rule_template_id Int,
dq_metric varchar(50) Not Null,
rule_template_name varchar(50) Not NUll,
rule_template_desc varchar(500) Not NUll,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(rule_template_id),
CONSTRAINT unique_rule_template Unique(dq_metric, rule_template_name)
);

CREATE TABLE rule_template_properties
(
rule_template_prop_id Int Unique,
rule_template_prop_key Varchar(50),
rule_template_prop_type Varchar(50) Not Null,
rule_template_prop_value Varchar(500) Not Null,
rule_template_prop_desc Varchar(500) Not Null,
is_mandatory Varchar(50) Not Null,
rule_template_id int Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(rule_template_prop_id),
CONSTRAINT fk_rule_template FOREIGN KEY(rule_template_id) REFERENCES rule_template(rule_template_id),
CONSTRAINT unique_rule_template_props Unique(rule_template_prop_key, rule_template_id)
);

CREATE TABLE entity_template
(
entity_template_id Int,
entity_template_type varchar(50) Not Null,
entity_template_subtype varchar(50) Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(entity_template_id),
CONSTRAINT unique_rule_template1 Unique(entity_template_type, entity_template_subtype)
);

CREATE TABLE entity_template_properties
(
entity_template_prop_id Int,
entity_template_prop_key Varchar(50) Unique,
entity_template_prop_type Varchar(50) Not Null,
entity_template_prop_desc Varchar(500) Not Null,
is_mandatory Varchar(50) Not Null,
entity_template_id int Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(entity_template_prop_id),
CONSTRAINT fk_entity_template FOREIGN KEY(entity_template_id) REFERENCES entity_template(entity_template_id),
CONSTRAINT unique_entity_template_props Unique(entity_template_prop_key, entity_template_id)
);

CREATE TABLE entity
(
entity_id Int,
entity_physical_name varchar(500) Not Null,
entity_name varchar(500) Not Null,
entity_primary_key varchar(500) Not Null,
entity_template_id Int Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(entity_id),
CONSTRAINT fk_entity_temp_id FOREIGN KEY(entity_template_id) REFERENCES entity_template(entity_template_id),
CONSTRAINT unique_entity_table Unique(entity_template_id, entity_physical_name )
);

CREATE TABLE entity_properties
(
entity_prop_id Int,
entity_prop_key varchar(50) Not Null,
entity_prop_value varchar(500) Not Null,
entity_id int Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(entity_prop_id),
CONSTRAINT fk_entity_prop FOREIGN KEY(entity_id) REFERENCES entity(entity_id),
CONSTRAINT unique_entity_table1 Unique(entity_prop_key, entity_id)
);

CREATE TABLE ruleset
(
ruleset_id Int,
ruleset_name Varchar(100) Unique,
ruleset_desc Varchar(500) Not Null,
notification_email Varchar(500) Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(ruleset_id)
);

CREATE TABLE rule
(
rule_id Int,
ruleset_id Int Not Null,
rule_template_id Int Not Null,
rule_name varchar(100) Not Null,
rule_desc varchar(500) Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(rule_id),
CONSTRAINT fk_ruleset FOREIGN KEY(ruleset_id) REFERENCES ruleset(ruleset_id),
CONSTRAINT fk_rule_template_rule FOREIGN KEY(rule_template_id) REFERENCES rule_template(rule_template_id)
);

CREATE TABLE rule_entity_map
(
rule_entity_map_id Int,
rule_id Int Not Null,
entity_id Int Not Null,
entity_behaviour Varchar(50) Not Null,
is_primary Varchar(10) Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(rule_entity_map_id),
CONSTRAINT fk_rule_entity1 FOREIGN KEY(rule_id) REFERENCES rule(rule_id),
CONSTRAINT fk_rule_entity2 FOREIGN KEY(entity_id) REFERENCES entity(entity_id),
CONSTRAINT unique_rule_entity_table Unique(rule_id, entity_id)
);

CREATE TABLE rule_properties
(
rule_prop_id Int,
rule_prop_key Varchar(50) Not Null,
rule_prop_value Varchar(500) Not Null,
rule_id Int Not Null,
created_by Varchar(50) Not Null,
created_date timestamp Not Null,
updated_by Varchar(50) Not Null,
updated_date timestamp Not Null,
PRIMARY KEY(rule_prop_id),
CONSTRAINT fk_rule FOREIGN KEY(rule_id) REFERENCES rule(rule_id),
CONSTRAINT unique_rule_prop Unique(rule_prop_key, rule_id)
);