import os
import pandas as pd
from sqlalchemy import create_engine
from dotenv import load_dotenv

load_dotenv()
DATABASE_URL = os.getenv("DATABASE_URL")
DATA_DIR = os.getenv("DATA_DIR", "./csv")

engine = create_engine(DATABASE_URL)

PARSE_DATES = {
    "olist_orders_dataset.csv": ["order_purchase_timestamp"],
    "olist_order_items_dataset.csv": ["shipping_limit_date"],
    "olist_order_reviews_dataset.csv": ["review_creation_date", "review_answer_timestamp"],
}


def import_csv_to_postgres():
    # # 1. Geolocations
    # print("Loading geolocations...")
    # geolocations = pd.read_csv(os.path.join(DATA_DIR, "olist_geolocation_dataset.csv"))
    # geolocations = geolocations.drop_duplicates(
    # subset=["geolocation_zip_code_prefix", "geolocation_lat", "geolocation_lng"]
    # )
    # geolocations.to_sql("geolocations", engine, schema="ecommerce", if_exists="append", index=False)

    # # 2. Customers
    # print("Loading customers...")
    customers = pd.read_csv(os.path.join(DATA_DIR, "olist_customers_dataset.csv"))
    # customers.to_sql("customers", engine, schema="ecommerce", if_exists="append", index=False)

    # # 3. Sellers
    # print("Loading sellers...")
    # sellers = pd.read_csv(os.path.join(DATA_DIR, "olist_sellers_dataset.csv"))
    # sellers.to_sql("sellers", engine, schema="ecommerce", if_exists="append", index=False)

    # # 4. Product category translation 
    # print("Loading product_category_translation...")
    # translations = pd.read_csv(os.path.join(DATA_DIR, "product_category_name_translation.csv"))
    # translations.to_sql("product_category_translation", engine, schema="ecommerce", if_exists="append", index=False)

    # # 5. Products 
    # print("Loading products...")
    # products = pd.read_csv(os.path.join(DATA_DIR, "olist_products_dataset.csv"))
    # products.to_sql("products", engine, schema="ecommerce", if_exists="append", index=False)

    # # 6. Orders
    # print("Loading orders...")
    orders = pd.read_csv(
        os.path.join(DATA_DIR, "olist_orders_dataset.csv"),
        parse_dates=PARSE_DATES.get("olist_orders_dataset.csv"),
    )
    orders = orders[orders["customer_id"].isin(customers["customer_id"])]
    # orders.to_sql("orders", engine, schema="ecommerce", if_exists="append", index=False)

    # # 7. Order items
    # print("Loading order_items...")
    # order_items = pd.read_csv(
    #     os.path.join(DATA_DIR, "olist_order_items_dataset.csv"),
    #     parse_dates=PARSE_DATES.get("olist_order_items_dataset.csv"),
    # )
    # order_items = order_items[order_items["order_id"].isin(orders["order_id"])]
    # order_items = order_items[order_items["product_id"].isin(products["product_id"])]
    # order_items = order_items[order_items["seller_id"].isin(sellers["seller_id"])]
    # order_items.to_sql("order_items", engine, schema="ecommerce", if_exists="append", index=False)

    # # 8. Payments
    # print("Loading payments...")
    # payments = pd.read_csv(os.path.join(DATA_DIR, "olist_order_payments_dataset.csv"))
    # payments = payments[payments["order_id"].isin(orders["order_id"])]
    # payments.to_sql("payments", engine, schema="ecommerce", if_exists="append", index=False)

    # 9. Reviews
    print("Loading reviews...")
    reviews = pd.read_csv(
        os.path.join(DATA_DIR, "olist_order_reviews_dataset.csv"),
        parse_dates=PARSE_DATES.get("olist_order_reviews_dataset.csv"),
    )
    reviews = reviews[reviews["order_id"].isin(orders["order_id"])]
    
    reviews.to_sql("reviews", engine, schema="ecommerce", if_exists="append", index=False)

    print("Import completed with data cleaned!")


if __name__ == "__main__":
    import_csv_to_postgres()
