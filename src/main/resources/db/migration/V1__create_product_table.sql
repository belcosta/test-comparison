DROP TABLE if exists bed_sheet;

DROP TYPE IF EXISTS product_type;
CREATE TYPE product_type as ENUM (
    'BED_SHEET',
    'CURTAIN',
    'TABLECLOTH',
    'DISHCLOTH'

);

DROP TYPE IF EXISTS textile_material;
CREATE TYPE textile_material as ENUM (
    'BAMBOO',
    'COTTON',
    'LINEN',
    'SILK'
);

DROP TYPE IF EXISTS bed_sheet_size;
CREATE TYPE bed_sheet_size as ENUM (
    'SINGLE',
    'DOUBLE',
    'QUEEN',
    'KING'
);

CREATE TABLE IF NOT EXISTS bed_sheet (
                         id BIGSERIAL PRIMARY KEY,
                         product_type varchar NOT NULL,
                         price NUMERIC(10, 2) NOT NULL,
                         material varchar NOT NULL,
                         size varchar NOT NULL
);
