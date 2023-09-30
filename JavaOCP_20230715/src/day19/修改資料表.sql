-- 修改 branch 資料表 alter
-- 將 city + branch_name 的資料具有唯一性
-- 預設的約束名 city
alter table branch add unique(city, branch_name);

-- 修改 product 資料表 alter
-- 將 product_name + price 的資料具有唯一性
-- 預設的約束名 product_name
alter table product add unique(product_name, price);

-- 移除指定約束
alter table branch drop constraint city;
alter table product drop constraint product_name;

-- 自訂約束名
alter table branch add constraint city_branch_name_unique unique(city, branch_name);
alter table product add constraint product_name_price_unique unique(product_name, price);