默认的静态资源路径为：
- classpath:/META-INF/resources/
- classpath:/resources/
- classpath:/static/
- classpath:/public/
我们常用的是 static
注意：将静态资源放到这些目录下，想直接访问静态资源时，就以这些目录为根目录。如放到static下，访问路径不用加static，直接ip:prot/resource