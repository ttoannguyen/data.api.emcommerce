CREATE SCHEMA IF NOT EXISTS ecommerce;

-- Bảng địa lý
CREATE TABLE IF NOT EXISTS ecommerce.geolocations (
    geolocation_zip_code_prefix VARCHAR,
    geolocation_lat NUMERIC,
    geolocation_lng NUMERIC,
    geolocation_city VARCHAR,
    geolocation_state VARCHAR,
    PRIMARY KEY (
        geolocation_zip_code_prefix,
        geolocation_lat,
        geolocation_lng
    )
);

-- Bảng khách hàng (không FK)
CREATE TABLE IF NOT EXISTS ecommerce.customers (
    customer_id VARCHAR PRIMARY KEY,
    customer_unique_id VARCHAR,
    customer_zip_code_prefix VARCHAR,
    customer_city VARCHAR,
    customer_state VARCHAR
);

-- Bảng người bán (không FK)
CREATE TABLE IF NOT EXISTS ecommerce.sellers (
    seller_id VARCHAR PRIMARY KEY,
    seller_zip_code_prefix VARCHAR,
    seller_city VARCHAR,
    seller_state VARCHAR
);

-- Bảng sản phẩm
CREATE TABLE IF NOT EXISTS ecommerce.products (
    product_id VARCHAR PRIMARY KEY,
    product_category_name VARCHAR,
    product_name_length INT,
    product_description_length INT,
    product_photos_qty INT,
    product_weight_g INT,
    product_length_cm INT,
    product_height_cm INT,
    product_width_cm INT
);

-- Bảng dịch tên category
CREATE TABLE IF NOT EXISTS ecommerce.product_category_translation (
    product_category_name VARCHAR PRIMARY KEY,
    product_category_name_english VARCHAR
);

-- Bảng đơn hàng
CREATE TABLE IF NOT EXISTS ecommerce.orders (
    order_id VARCHAR PRIMARY KEY,
    customer_id VARCHAR REFERENCES ecommerce.customers (customer_id),
    order_status VARCHAR,
    order_purchase_timestamp TIMESTAMP,
    order_approved_at TIMESTAMP,
    order_delivered_carrier_date TIMESTAMP,
    order_delivered_customer_date TIMESTAMP,
    order_estimated_delivery_date TIMESTAMP
);

-- Bảng chi tiết đơn hàng
CREATE TABLE IF NOT EXISTS ecommerce.order_items (
    order_id VARCHAR REFERENCES ecommerce.orders (order_id),
    order_item_id INT,
    product_id VARCHAR REFERENCES ecommerce.products (product_id),
    seller_id VARCHAR REFERENCES ecommerce.sellers (seller_id),
    shipping_limit_date TIMESTAMP,
    price NUMERIC,
    freight_value NUMERIC,
    PRIMARY KEY (order_id, order_item_id)
);

-- Bảng thanh toán
CREATE TABLE IF NOT EXISTS ecommerce.payments (
    order_id VARCHAR REFERENCES ecommerce.orders (order_id),
    payment_sequential INT,
    payment_type VARCHAR,
    payment_installments INT,
    payment_value NUMERIC,
    PRIMARY KEY (order_id, payment_sequential)
);

-- Bảng review
CREATE TABLE IF NOT EXISTS ecommerce.reviews (
    review_id VARCHAR,
    order_id VARCHAR REFERENCES ecommerce.orders (order_id),
    review_score INT,
    review_comment_title TEXT,
    review_comment_message TEXT,
    review_creation_date TIMESTAMP,
    review_answer_timestamp TIMESTAMP,
    PRIMARY KEY (review_id, order_id)
);

SELECT p.product_id, p.product_category_name, p.product_name_length, COUNT(oi.product_id) AS total_sold
FROM ecommerce.order_items oi
    JOIN ecommerce.products p ON oi.product_id = p.product_id
GROUP BY
    p.product_id,
    p.product_category_name
ORDER BY total_sold DESC
LIMIT 10;

SELECT DATE_TRUNC(
        'month', o.order_purchase_timestamp
    ) AS month, SUM(oi.price + oi.freight_value) AS revenue
FROM ecommerce.orders o
    JOIN ecommerce.order_items oi ON o.order_id = oi.order_id
GROUP BY
    month
ORDER BY month;

SELECT pct.product_category_name_english AS product_name, COUNT(oi.product_id) AS total_sold
FROM ecommerce.order_items oi
    JOIN ecommerce.products p ON oi.product_id = p.product_id
    JOIN ecommerce.product_category_translation pct ON p.product_category_name = pct.product_category_name
GROUP BY
    pct.product_category_name_english
ORDER BY total_sold DESC
LIMIT 10;