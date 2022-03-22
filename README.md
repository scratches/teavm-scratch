Spring Boot will be used as a vehicle for hosting the generated JavaScript, but any web server can do that just as well. To get started we create a [new web application](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.4&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=webflux). Unpack it andopen it up in an IDE. There is a `DemoApplication` that you can run and see the app starting:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.6.4)

2022-03-18 09:12:14.122  INFO 2982482 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication using Java 11.0.14 on tower with PID 2982482 (/home/dsyer/dev/scratch/jsweet-demo/target/classes started by dsyer in /home/dsyer/dev/scratch/jsweet-demo)
2022-03-18 09:12:14.125  INFO 2982482 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to 1 default profile: "default"
2022-03-18 09:12:15.081  INFO 2982482 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2022-03-18 09:12:15.088  INFO 2982482 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 1.29 seconds (JVM running for 1.584)
```

Load the site into a browser at http://localhost:8080 and look at the console. We expect it to print a message but we get a stacktrace.

```
Uncaught ReferenceError: Yz is not defined
    at GX (classes.js:75)
    at V6 (classes.js:73)
    at IR (classes.js:1568)
    at MV (classes.js:1567)
    at Object.cu (classes.js:29)
    at K$ (classes.js:1324)
    at O$ (classes.js:1323)
    at H1.ix (classes.js:29)
    at PG (classes.js:1441)
    at VX (classes.js:1439)
```

If you find usage of `Yz` in `classes.js` you can see that it looks like a typo (the function `Yy` is greyed out in the IDE because it is never used):

```javascript
...
function Yy(a,b){var c=new Dr();Fa(c,a,b);return c;}
function GX(a){CT();Fa(a,Yz,(R1()).jZ());}
...
```

You can manually edit it and replace `Yz` with `Yy` and it then works.