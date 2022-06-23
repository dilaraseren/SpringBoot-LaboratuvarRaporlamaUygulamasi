## Laboratuvar Raporlama Uygulaması

# Kullanılan Teknolojiler
* Spring Boot
* Thymeleaf
* JPA
* Maven
* Bootstrap
* PostgreSQL

* Proje kurulumu için aşağıdaki gerekli adımları sırayla uygulamanız gerekmektedir.

## Editör Kurulumu
* [Intellij IDEA Ultimate] - editörünü kurmanız gerekmektedir.
* [Java JDK 11] - en az kurulu olması gerekmektedir.
* [PostgreSQL] - kurulması gerekmektedir.

## Proje Kurulumu
Proje kurulumu için gerekli adımları takip ediniz.

* Projeyi bilgisayarınıza indiriniz. 
* Ardından PostgreSQL indiriniz. PostgreSQL indirdikten sonra ve projeyi Intellij IDEA'da açtıktan sonra application.properties kısmında bu kodları yapıştırınız.
*  username ve password kısmını PostgreSQL'i bilgisayarınıza kurarken belirlediğiniz username ve password'e göre değişiklik yapınız. Değişiklikleri kaydedip devam edebilirsiniz. 

```sh
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update 
spring.jpa.hibernate.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/DbLaboratuvar
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.properties.javax.persistence.validation.mode = none

```

Daha sonra PostgreSQL'de pgAdmin'de bir veritabanı oluşturun ve adına DbLaboratuvar diyin.
model katmanındaki sınıfların içinde tek tek kaydet işlemi yapın bu şekilde ilişkili tablolar PostgreSQL tarafına yansıyacaktır zira code-first yaklaşımı kullanılmaktadır. Ardından projeyi localhost'ta açıp ilgili işlemleri yapabilirsiniz.

## Proje Gereksinimleri
* Rapor Tanımı ( Dosya numarası, Hasta Ad ve Soyad, Hasta Kimlik
Numarası(TC), Koyulan Tanı Başlığı, Tanı Detayları, Raporun Verildiği
Tarih, Fiziksel Rapora Ait .png/.jpg Formatında Bir Adet Fotoğraf )  + 
* Bir rapor yalnızca bir laborant tarafından tanımlanmış olmalı. Bir
laborant ise  n tane rapor tanımlayabilir. ( Ad, Soyad, Hastane Kimlik
Numarası(7 Haneli), )   + 
* Hasta adı/soyadı, Hasta kimlik numarası, Laborant adı/soyadı
bilgileri ile arama yapılabilmeli. Rapor tarihi ile sıralama
yapılabilmeli  + 
* Var olan bir rapor üzerinde değişiklik yapılabilmeli + 
* Var olan tüm raporların detayları incelenebilmeli + 
* Var olan bir rapor silinebilmeli  +

Beklentilerimiz:
* Kod standartlarına uygun yazılım geliştirilmesi + 
* Uygulamanın çalıştırılabilir hale getirilmesi için bir IDE
kullanılması gerekmemesi

Bir adım öne çıkayım derseniz:
* Birim test içermesi elbette bir artı olarak değerlendirilir. +
* Kullanıcılar sisteme kullanıcı adı/parola ile giriş yapmalı + 
* Bir yetkilendirme mekanizması içermeli. Örneğin standart kullanıcılar
kayıt oluşturabilsin ilişkilendirebilsin fakat silemesin. Yönetici tüm
eylemleri gerçekleştirebilsin.







   
   
