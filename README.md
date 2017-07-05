**Exemple de microservice**

Pour utiliser la démo avec le rechargement de la conguration, vous avez besoin de rabbitMQ,
 
Pour celà, utilisez docker et démarrer la commande suivante :

```bash
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p4369:4369 -p 5671:5671 -p 5672:5672 -p 25672:25672 rabbitmq:3-management
```


Pour recharger la configuration :

curl http://localhost:11111/monitor -d path="*"

Le serveur de configuration propage un évènement sur le bus RabbitMQ et le microservice docs-services se rechargera