
ALTER TABLE contract
    ADD COLUMN film_id uuid REFERENCES film;