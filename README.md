# 🛒 kata-order-importer
El objectivo de esta aplicación es realizar la importación a una base de datos, una lista de pedidos online disponibles en una API pública.
Además devolverá los resultados de la importación y dará la posibilidad de descargar estos pedidos en un CSV.

Para ello, se han creado dos endpoints:

`GET /orders/import`

Realiza la importación de los pedidos y devuelve un json con los pedidos totales y el del conteo según diferentes características: Region, Country, Item Type, Sales Channel, Order Priority.

`GET /orders/download`

Realiza la descarga de todos los pedidos importados en un CSV. El fichero resultante está ordenado por orderId.

El proceso de importación es bastante pesado, ya que hay 1.000.000 de pedidos en total. Además, hay que obtener estos pedidos de manera paginada a través de la API proporcionada.
Para disminuir el número de llamadas a la API se ha enviado el queryParam `max-per-page=1000`, ya que por defecto solo se recogen 100.

El proceso de importación dura unos 10 min, mientras que el de descarga del csv son 3 min.
