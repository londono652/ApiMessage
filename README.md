#APIMessage

Microservicio Java realizado con Springboot y el gestor de dependencias Gradle, usando arquitectura recomendada de buenas prácticas creando una separación de las capas controller, service, models, repositories,exceptions, security.
La seguridad de la aplicación es implementada a partir de la dependencia Spring security.

Para realizar la petición se debe primero obtener el token JWT con una petición POST en el endpoint /token y con los siguientes parámetros: 

curl --location --request POST ‘url:port/token?user=USER&password=PASSWORD’

la respuesta será:

{
"access_token": "token",
"token_type": "X-JWT-KWY",
"expires_in": 600000
}

Luego de obtener el token se realiza la petición POST al endpoint /devops usando los header de la APIKEY y el del token JWT generado en el paso anterior:

curl --location --request POST 'url:port/devops' \
--header 'X-Parse-REST-API-Key: 2f5ae96c-b558-4c7b-a590-a501ae1c3f6c' \
--header 'X-JWT-KWY: ##Aquí va el token### ' \
--header 'Content-Type: application/json' \
--data-raw '{
"msg": "This is a test",
"to": "Juan Perez",
"from": "Rita Asturia",
"timeToLifeSec": 45
}'

la respuesta será:

{
"message": "Hello, "from:value" your message will be send"
}

El microservicio cuenta con pruebas unitarias realizadas para algunas clases del proyecto y con el plugin de Jacoco para evidenciar temas de cobertura de código.

DevOps

Como herramienta de CI/CD se tiene un pipeline como código azure-pipeline.yaml ejecutado en la plataforma Azure Devops, se crean service connection para integración con aws, dockerhub, sonarcloud y el cluster eks de kubernetes previamente en la organización de azure.
Ejecutará las siguientes tareas:

Integración Continua (CI)

	Gradle Build: Compilación del artefacto Java

	Gradle Unit Test: Pruebas Unitarias del código

	SonarCloud Analysis : Análisis de código estático y breaker para romper el pipe si no se cumple los parámetros del quality gate
Url Reporte Sonar: https://sonarcloud.io/project/overview?id=londono652_ApiMessage

	Creación imagen Docker: Creación de la imagen docker del microservicio

	Scan vulnerabilidades en imagen con Trivy : Escaneo de vulnerabilidades a la imagen

	Compresion Zip artefacto: Compresión en zip del artefacto para archivado y auditoria

	Publicación en Azure artifacts : Publicación en Azure Artifacts

	Publicación imagen en AWS ECR: Publicación de imagen en registry privado aws 


Deployment (CD)

	Despliegue en EKS: Despliegue en cluster kubernetes en aws de la aplicación.

SmokeTest

	Script en Shell (smoketest/test-messageapi.sh)con Prueba automatizada para validar el estado (200 ok) de la aplicación luego del deploy3443