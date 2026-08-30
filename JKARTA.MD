\# javax → jakarta



El cambio de `javax.\*` a `jakarta.\*` ocurrió con \*\*Jakarta EE 9\*\*, publicada en \*\*diciembre de 2020\*\*.



\### Cronología



\* \*\*2017:\*\* Oracle transfiere Java EE a Eclipse Foundation.

\* \*\*2019 — Jakarta EE 8:\*\* todavía utiliza `javax.\*`.

\* \*\*2020 — Jakarta EE 9:\*\* se cambia el namespace de:



&#x20; ```text

&#x20; javax.\* → jakarta.\*

&#x20; ```

\* \*\*2021 en adelante:\*\* las nuevas versiones de Jakarta EE utilizan `jakarta.\*`.



\### ¿Por qué?



Eclipse Foundation no podía seguir evolucionando las APIs bajo el namespace `javax.\*` debido a restricciones sobre las marcas y derechos de Java EE. Por eso se creó el nuevo namespace `jakarta.\*`.



Ejemplo:



```java

// Antes

import javax.persistence.Entity;



// Desde Jakarta EE 9

import jakarta.persistence.Entity;

```



\### Importante



Esto \*\*no significa que `javax` haya desaparecido de Java\*\*.



El cambio afecta principalmente a las APIs de \*\*Java EE/Jakarta EE\*\*. Java SE todavía tiene paquetes `javax.\*`.



Por tanto:



```text

Java EE 8 / Jakarta EE 8 → javax.\*

Jakarta EE 9+             → jakarta.\*

```



Y el cambio \*\*no ocurrió por Java 11, Java 17 o Java 21\*\*. Fue un cambio de \*\*Jakarta EE 9\*\*, no de la versión de Java.



