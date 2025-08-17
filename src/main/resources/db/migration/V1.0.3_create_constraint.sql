DROP CONSTRAINT IF NOT EXISTS fk_supplier;

ALTER TABLE test.activity
ADD CONSTRAINT fk_supplier
FOREIGN KEY (supplier_id)
REFERENCES test.supplier(id);