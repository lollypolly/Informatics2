1
select model, speed, hd from PC where price < 500

2
select maker from product where product.type = 'printer' group by maker

3
select model, ram, screen from Laptop where price > 1000

4
select * from printer where color='y'

5
select model, speed, hd from PC where (cd='12x' or cd='24x') and price<600

6
select distinct Product.maker, Laptop.speed
from Product, Laptop
WHERE Laptop.model = Product.model and Laptop.hd >= 10 and Product.TYPE = 'laptop'

7
select distinct product.model, pc.price
from Product join pc on product.model = pc.model where maker = 'B'
union
select distinct product.model, laptop.price
from product join laptop on product.model=laptop.model where maker='B'
union
select distinct product.model, printer.price
from product join printer on product.model=printer.model where maker='B'

8
select distinct Maker from Product where type='PC' and type='PC'
except
select distinct Maker from Product where type='Laptop'

9
select distinct maker from product join pc on Product.model = PC.model where pc.speed>=450

10
select model, price from printer where price =(select max(price) from printer )

11
select AVG(speed) from PC

12
select AVG(speed) from Laptop where price>1000

13
select AVG(speed) from PC join Product on Product.model=PC.model where maker='A'

14
select classes.class , name,country from classes inner join ships on classes.class = ships.class
where numguns >= 10

15
select hd from pc group by (hd) having count(model) >= 2

16
select distinct p1.model, p2.model, p1.speed, p1.ram from pc p1, pc p2
where p1.speed = p2.speed and p1.ram = p2.ram and p1.model > p2.model

17
select distinct p.type,p.model,l.speed from laptop l join product p on l.model=p.model where l.speed<(select min(speed) from pc)

18
select distinct Product.maker, Printer.price from Product join Printer on
Product.model=Printer.model where Printer.color='y' and Printer.price=(select
min(price) from Printer where color='y')

19
elect Product.maker, AVG(Laptop.Screen)
from Product join Laptop on Product.model=Laptop.model group by maker

20
select maker, count(model) from product where type = 'pc' group by product.maker
having count (distnct model) >= 3

21
select Product.maker, max(PC.price) from Product join PC on Product.model=PC.model
group by maker


22
select PC.speed, AVG(PC.price) from PC group by PC.speed having AVG(PC.speed)>600

23
select distinct maker from product t1 join pc t2 on t1.model=t2.model
where speed>=750 and maker in
( select maker from product t1 join laptop t2 on t1.model=t2.model where speed>=750 )

select model
from (select model, price from pc
union
select model, price from Laptop
union
select model, price from Printer) t1
where price = (select max(price) from (select price from pc
union
select price from Laptop
union
select price from Printer) t2)


25
select distinct maker from product where model in (select model from pc where ram = (select min(ram) from pc) and speed = (select max(speed) from pc where ram = (
select min(ram) from pc))) and maker in (select maker from product where type='printer')

26
select AVG(price) as AVG_price from (select model, price from PC
union all
select model, price from Laptop) as price
inner join Product as p
on price.model = p.model
where maker = 'A'

27
select product.maker, AVG(pc.hd) from pc, product where product.model = pc.model
and product.maker in ( select distinct maker from product where product.type = 'printer') group by maker

28
select count(maker) from (select maker from Product group by maker having count(model)=1)zq

29
select t.point, t.date, SUM(t.inc), sum(t.out) from( select point, date, inc, null as out from Income_o
union
select point, date, null as inc, Outcome_o.out from Outcome_o) as t group by t.point, t.date

31
select class , country from classes where bore >= 16
