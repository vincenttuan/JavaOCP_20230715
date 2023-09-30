-- 修改 branch 資料表 alter
-- 將 city + branch_name 的資料具有唯一性
alter table branch add unique(city, branch_name);

-- 修改 product 資料表 alter
-- 將 product_name + price 的資料具有唯一性
alter table product add unique(product_name, price);


