## Ödev 5
**1) film tablosunda bulunan ve film ismi (title) 'n' karakteri ile biten en uzun (length) 5 filmi sıralayınız.**

```sql
  SELECT * FROM film
  WHERE title LIKE '%n'
  ORDER BY length DESC
  LIMIT 5;
```

**2) Film tablosunda bulunan ve film ismi (title) 'n' karakteri ile biten en kısa (length) ikinci(6,7,8,9,10) 5 filmi(6,7,8,9,10) sıralayınız.**
```sql
  SELECT film_id, title, length FROM film
  WHERE title LIKE '%n'
  ORDER BY length ASC
  OFFSET 5
  LIMIT 5;
```

**3) Customer tablosunda bulunan last_name sütununa göre azalan yapılan sıralamada store_id 1 olmak koşuluyla ilk 4 veriyi sıralayınız.**
```sql
  SELECT * FROM customer
  WHERE store_id = 1
  ORDER BY last_name DESC
  LIMIT 4;
```

## Ödev 6
**1) Film tablosunda bulunan rental_rate sütunundaki değerlerin ortalaması nedir?**
```sql
  SELECT ROUND(AVG(rental_rate),4) AS avarage_rental_rate FROM film;
```
**2) Film tablosunda bulunan filmlerden kaç tanesi 'C' karakteri ile başlar?**

```sql
  SELECT COUNT(*) AS start_with_c FROM film
  WHERE title LIKE 'C%';
```
**3) Film tablosunda bulunan filmlerden rental_rate değeri 0.99 a eşit olan en uzun (length) film kaç dakikadır?**

```sql
  SELECT MAX(length) FROM film
  WHERE rental_rate = 0.99;
```
**4) Film tablosunda bulunan filmlerin uzunluğu 150 dakikadan büyük olanlarına ait kaç farklı replacement_cost değeri vardır?**

```sql
  SELECT COUNT(DISTINCT(replacement_cost)) FROM film
  WHERE length > 150
```

## Ödev 7
**1) Film tablosunda bulunan filmleri rating değerlerine göre gruplayınız.**
```sql
  SELECT rating, COUNT(*) FROM film
  GROUP BY rating;
```
**2) Film tablosunda bulunan filmleri replacement_cost sütununa göre grupladığımızda film sayısı 50 den fazla olan replacement_cost değerini ve karşılık gelen film sayısını sıralayınız.**

```sql
  SELECT replacement_cost, COUNT(*) FROM film
  GROUP BY replacement_cost
  HAVING COUNT(*) > 50;
```
**3) Customer tablosunda bulunan store_id değerlerine karşılık gelen müşteri sayılarını nelerdir?**

```sql
  SELECT store_id, COUNT(*) FROM customer
  GROUP BY store_id
```
**4) City tablosunda bulunan şehir verilerini country_id sütununa göre gruplandırdıktan sonra en fazla şehir sayısı barındıran country_id bilgisini ve şehir sayısını paylaşınız.**

```sql
  SELECT country_id, COUNT(country_id) FROM city  
  GROUP BY country_id
  ORDER BY COUNT(country_id) DESC
  LIMIT 1;
```

## Ödev 8 (Tablolarla Çalışmak)
**1) Test veritabanınızda employee isimli sütun bilgileri id(INTEGER), name VARCHAR(50), birthday DATE, email VARCHAR(100) olan bir tablo oluşturalım.**
```sql
  CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    birthday DATE DEFAULT CURRENT_DATE,
    email VARCHAR(100);
```
**2) Oluşturduğumuz employee tablosuna 'Mockaroo' servisini kullanarak 50 adet veri ekleyelim.**

```sql
insert into employee (name, birthday, email) values ('Maurits', '1994-02-27', 'mhartwell0@cdc.gov');
insert into employee (name, birthday, email) values ('Taite', '1963-06-04', 'tpipkin1@ebay.com');
...
insert into employee (name, birthday, email) values ('Catlin', null, 'cwythill1d@samsung.com');
```

**3) Sütunların her birine göre diğer sütunları güncelleyecek 5 adet UPDATE işlemi yapalım.**

```sql
UPDATE employee
SET name = 'updated',
    birthday = '1555-05-15',
    email = 'updated@email.com
WHERE id = 1;

UPDATE employee
SET name = 'updated1',
    birthday = '1555-05-15',
    email = 'updated1@email.com
WHERE name LIKE '%a';

UPDATE employee
SET name = 'updated2',
    birthday = '1555-05-15',
    email = 'updated2@email.com
WHERE email IS NULL;

UPDATE employee
SET name = 'updated3',
    birthday = '1555-05-15',
    email = 'updated3@email.com
WHERE id > 30;

UPDATE employee
SET name = 'updated4',
    birthday = '1555-05-15',
    email = 'updated4@email.com
WHERE name ILIKE '%__a%' AND email IS NOT NULL;
```
**4) Sütunların her birine göre ilgili satırı silecek 5 adet DELETE işlemi yapalım.**
```sql
DELETE FROM employee
WHERE id = 1;

DELETE FROM employee
WHERE name LIKE '%a';

DELETE FROM employee
WHERE email IS NULL;

DELETE FROM employee
WHERE id > 30;

DELETE FROM employee
WHERE name ILIKE '%__a%' AND email IS NOT NULL;
```

## Ödev 9 (INNER JOIN)
**1) City tablosu ile country tablosunda bulunan şehir (city) ve ülke (country) isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.**
```sql
SELECT country, city FROM city
INNER JOIN country 
ON country.country_id = city.city_id; 
```

**2) Customer tablosu ile payment tablosunda bulunan payment_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.**
```sql
SELECT customer.first_name, customer.last_name, payment.payment_id
FROM customer
INNER JOIN payment
ON customer.customer_id = payment.customer_id;
```
**3) Customer tablosu ile rental tablosunda bulunan rental_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz INNER JOIN sorgusunu yazınız.**
```sql
SELECT customer.first_name, customer.last_name, rental.rental_id
FROM customer
INNER JOIN rental
ON customer.customer_id = rental.customer_id;
```
## Ödev 10 (LEFT - RİGHT , FULL JOIN)
**1) City tablosu ile country tablosunda bulunan şehir (city) ve ülke (country) isimlerini birlikte görebileceğimiz LEFT JOIN sorgusunu yazınız.**
```sql
SELECT country, city FROM city
LEFT JOIN country 
ON country.country_id = city.country_id;
```
**2) Customer tablosu ile payment tablosunda bulunan payment_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz RIGHT JOIN sorgusunu yazınız.**
```sql
SELECT payment_id, first_name, last_name FROM payment
RIGHT JOIN customer 
ON payment.customer_id = customer.customer_id;
```
**3) Customer tablosu ile rental tablosunda bulunan rental_id ile customer tablosundaki first_name ve last_name isimlerini birlikte görebileceğimiz FULL JOIN sorgusunu yazınız.**
```sql
SELECT customer.first_name, customer.last_name, rental.rental_id
FROM customer
FULL JOIN rental 
ON customer.customer_id = rental.customer_id;
```

## Ödev 11 (INTERSECT ve EXCEPT)
**1) Actor ve customer tablolarında bulunan first_name sütunları için tüm verileri sıralayalım.**
```sql
(SELECT first_name FROM customer)
UNION
(SELECT first_name FROM actor);
```

**2)actor ve customer tablolarında bulunan first_name sütunları için kesişen verileri sıralayalım.**
```sql
SELECT first_name FROM customer
INTERSECT
SELECT first_name FROM actor
```

**3) actor ve customer tablolarında bulunan first_name sütunları için ilk tabloda bulunan ancak ikinci tabloda bulunmayan verileri sıralayalım.**
```sql
SELECT first_name FROM customer
EXCEPT
SELECT first_name FROM actor
```
**4) İlk 3 sorguyu tekrar eden veriler için de yapalım.**
```sql
(SELECT first_name FROM customer)
UNION ALL
(SELECT first_name FROM actor);

SELECT first_name FROM customer
INTERSECT ALL
SELECT first_name FROM actor

SELECT first_name FROM customer
EXCEPT ALL
SELECT first_name FROM actor
```

## Ödev 12 (ALT SORGU)
**1) Film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?**
```sql
SELECT length, 
(SELECT MAX(length) FROM film),
((SELECT MAX(length) FROM film)-length) 
AS fark
FROM film;
```

**2) Film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?**
```sql
SELECT COUNT(rental_rate), 
(SELECT MAX(rental_rate)FROM film) 
FROM film
WHERE rental_rate >=(SELECT MAX(rental_rate)FROM film)
```

**3) Film tablosunda en düşük rental_rate ve en düşük replacement_cost değerlerine sahip filmleri sıralayınız.**
```sql
SELECT title, rental_rate, replacement_cost FROM film
WHERE rental_rate = ALL 
(
	SELECT MIN(rental_rate) FROM film
)
AND replacement_cost = ALL 
(
	SELECT MIN(replacement_cost) FROM film
); 
```

**4) Payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.**
```sql
SELECT payment.customer_id, customer.first_name, customer.last_name, count(payment.customer_id)  
FROM payment
INNER JOIN customer
ON customer.customer_id = payment.customer_id
GROUP BY payment.customer_id, customer.first_name, customer.last_name
ORDER BY COUNT(payment.customer_id) DESC;
```
