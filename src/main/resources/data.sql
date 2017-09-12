DELETE FROM VENDORS;
DELETE FROM CATEGORIES;

INSERT INTO VENDORS(id, name) values
(1, 'Neha'),
(2, 'Nidhi');

INSERT INTO CATEGORIES(id, name, description, disabled) values
(1, 'GreetingCards', 'Greeting Cards', FALSE),
(2, 'Jewellery', 'Jewellery', FALSE),
(3, 'Prints', 'Prints', FALSE),
(4, 'Boxes', 'Boxes', FALSE),
(5, 'WallHangings', 'Wall Hangings', FALSE);

INSERT INTO PRODUCTS(id, name, description, price, vendor_id, cat_id) values
(1, 'HBD Greeting Card', 'Happy Birthday Greeting Card', '15.0', 1, 1),
(2, 'Wedding Greeting Card', 'Wedding Greeting Card', '45.0', 1, 1),
(3, 'Necklace', 'Necklace', '25.0', 2, 2);
