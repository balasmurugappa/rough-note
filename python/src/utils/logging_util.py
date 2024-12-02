import logging

def configure_logger():
    """Configure the logger programmatically."""
    logger = logging.getLogger()
    handler = logging.StreamHandler()
    formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    handler.setFormatter(formatter)
    logger.addHandler(handler)
    logger.setLevel(logging.INFO)

def get_logger(name):
    configure_logger()  # Automatically sets up the logger
    return logging.getLogger(name)
