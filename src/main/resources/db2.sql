
CREATE TABLE SANDBOX.PRODUCTS (
  ID INTEGER,
  DESCRIPTION varchar(255),
  PRICE decimal(15,2)
);

CREATE OR REPLACE SEQUENCE SANDBOX.PRODUCTS_SEQ AS INTEGER;

INSERT INTO SANDBOX.PRODUCTS (id, description, price) values(1, 'Lamp', 5.78);

INSERT INTO SANDBOX.PRODUCTS (id, description, price) values(2, 'Table', 75.29);

INSERT INTO SANDBOX.PRODUCTS (id, description, price) values(3, 'Chair', 22.81);