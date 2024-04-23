<img  alt="exchangeimg" width="200px" height="200px" align="right" src="https://images.vexels.com/media/users/3/146882/isolated/preview/7525685ed67fa782b7d851273e1264c7-cambio-de-divisas.png" >

## Conversor de monedas

Proyecto para el programa ONE-Backend. La app está desarrollada en Java 17 para realizar la conversión de distintas monedas. Se basa en el consumo de la API de [ExchangeRate-API](https://www.exchangerate-api.com/), de este modo esta app se alimenta de los listados de países y de la tasa de cambio entre dos monedas dadas.

## Tabla de contenidos

- [Preparación del ambiente](#preparacion-del-ambiente)


### Preparacion del ambiente

Para la ejecución de la app es necesario seguir los pasos que te presento a continuación para evitar errores de compilación y/o ejecución:

#### 1. Configurar la variable de entorno

- Primero debes solicitar tu API-Key en la API de [ExchangeRate-API](https://www.exchangerate-api.com/), es completamente gratuito y solo debes añadir tu mail

<img  alt="apikey" width="700px" height="400px" src="https://github.com/PatoProgramador/Conversor-de-monedas/assets/72218702/a9dc5a07-d9b9-416d-ab08-b3f54dc6facc" >

- Luego, debes descargar este proyecto y abrirlo en tu IDE de preferencia :) `(recomiendo hacerlo desde Intellij para configurar todo más facil jeje)`.
- Nos ubicamos en el archivo principal `src/Main.java`, damos click derecho, nos ubicamos en `More run/ debug` y finalmente en `Modify run configuration...`
<img  alt="apikey" width="900px" height="800px" src="https://github.com/PatoProgramador/Conversor-de-monedas/assets/72218702/2e9824e0-ebd5-415b-9422-02aef4ae9d56" >

- Finalmente, añades tu api-key en el apartado de variables de entorno con el nombre de la variable: `EXCHANGE-API-KEY` y seleccionas `OK`.
<img  alt="env" width="700px" height="600px" src="https://github.com/PatoProgramador/Conversor-de-monedas/assets/72218702/ff59113e-5cff-4135-9df9-e0558bb371f7" >
