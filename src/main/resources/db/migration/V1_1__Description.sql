CREATE TABLE sum_results
(
  record_id SERIAL PRIMARY KEY,
  a INTEGER,
  b INTEGER,
  s INTEGER
);

CREATE TABLE people
(
  man_id SERIAL PRIMARY KEY,
  man_name TEXT
);
