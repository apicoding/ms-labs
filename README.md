**Exemple de microservice**

Pour utiliser la démo, vous avez besoin d'installer préalablement docker et de démarrer l'image spotify/kafka avec la commande suivante :

```bash
docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=`boot2docker ip` --env ADVERTISED_PORT=9092 spotify/kafka
```

Plus d'info sur docker hub : https://hub.docker.com/r/spotify/kafka/