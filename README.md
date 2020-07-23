Before app start you should to do several things:

1. Create docker container
docker run --name mysql57 -e MYSQL_DATABASE=eShop -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 -d mysql/mysql-server:5.7

2. Connect to container, connect to mysql server and change access to data base
docker exec -it mysql57 mysql -uroot -p

3. Exec sql command : update mysql.user set host = '%' where user='root';

4. You can start app now.