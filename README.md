# Probability API
This is a Spring Boot based REST API that simulates common objects used in probability calculations such as marbles, dice, and coins. The project uses an in-memory database, so no external database is required. You can use our pre-built docker image, or build the image yourself from the source code.

## Prerequisites
- [Docker](https://docs.docker.com/get-docker/)
- [Apache Maven](https://maven.apache.org/download.cgi) (If building from source)
- [Git](https://git-scm.com/downloads) (If building from source)

## Documentation
There are several forms of documentation available for the project. The GitHub documentation contains in-depth information about API usage, maintenance, etc. The project implements OpenAPI 3.0 compliant documentation that is available in JSON and YAML formats, as well as visual documentation using Swagger. Links to all of the documentation can be found below.
- [GitHub Documentation](https://github.com/samgerstner/probability_api/wiki)
- [JSON OpenAPI 3.0 Documentation](https://probability.samgerstner.pro/docs)
- [YAML OpenAPI 3.0 Documentation](https://probability.samgerstner.pro/docs.yaml)
- [Swagger/Visual Documentation](https://probability.samgerstner.pro/docs/visual)

## Quick Start
1. Pull the Docker image (`docker pull sgerstner/probability-api`)
2. Start the Docker container (`docker run -d --name probability-api
                                --publish 8080:8080 --env API_KEY=apikey
                                --env URL=http://localhoost:8080
                                --env CONTACT_NAME=name
                                --env CONTACT_EMAIL=contact@example.com
                                --env SERVER_DESC=Production
                                --restart unless-stopped
                                sgerstner/probability-api:latest`)

## Building From Source
1. Clone the GitHub repository (`git clone https://github.com/samgerstner/probability_api.git`)
2. Move into the project directory (`cd probability_api`)
3. Run maven installation command (`mvn install -DskipTests`)
4. Compile the project JAR file (`mvn clean package -DskipTests`)
4. Build the Docker image (`docker build -t probability-api:latest .`)

## Sandbox Environment
A sandbox/test environment is available so that you can try out the API. The API is available at `https://probability.samgerstner.pro/api` and the [Swagger UI](https://probability.samgerstner.pro/docs/visual) is available at `https://probability.samgerstner.pro/docs/visual`.