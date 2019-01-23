docker exec docker_db_1 sh -c "exec mysqldump --all-databases -uroot -pexample > /dump-all-databases.sql"
docker cp  docker_db_1:/dump-all-databases.sql dump-all-databases.sql

docker cp dump-all-databases.sql docker_db_1:/dump-all-databases.sql
docker exec -it docker_db_1 bash
mysql -uroot -pexample < /dump-all-databases.sql