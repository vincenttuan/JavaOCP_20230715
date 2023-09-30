-- 修改 branch 資料表alter
-- 將 city + branch_name 的資料具有唯一性
alter table branch add unique(city, branch_name);