CREATE TABLE IF NOT EXISTS Users (
    user_id SERIAL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    login TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
    accountType TEXT NOT NULL,
    salary TEXT NOT NULL,
    status TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Trucks (
    truck_id SERIAL,
    truck_brand TEXT NOT NULL,
    truck_year TEXT NOT NULL,
    truck_height TEXT NOT NULL,
    status TEXT NOT NULL
)

CREATE TABLE IF NOT EXISTS Trips (
    trip_id SERIAL,
    destination TEXT NOT NULL,
    delivery_date TIMESTAMP NOT NULL,
    shipment INT NOT NULL,
    user INT NOT NULL,
    truck INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Shipments (
    shipment_id SERIAL,
    description TEXT NOT NULL,
    weight TEXT NOT NULL
)