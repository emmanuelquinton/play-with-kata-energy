## Foreword
In this document I will describe the solution that I've implemented.

## API description

To describe the API I used an openAPI contract .
The openapi specifications are available [here](https://swagger.io/specification/)

To generate the API and the DTOs I use the openapi ggradle generator which is described [here](https://github.com/OpenAPITools/openapi-generator/blob/master/modules/openapi-generator-gradle-plugin/README.adoc) allows us to generate:


## Project Architecture

I use an hexagonal architecture in the project.
All classes are grouped into 4 distinct packages
- **api**:  which contains Controllers and Mapper (Dto <-> Model)
- **domain**: which contains use cases(services), models and port
- **storage**: which should contain the implementation of the secondary port and entities
- **application**: which contains configurations



