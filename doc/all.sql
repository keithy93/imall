drop table if exists `imooc_mall_cart`;
create table `imooc_mall_cart` (
    `id` int not null ,
    `product_id` int,
    `user_id` int ,
    `quantity` int ,
    `selected` int,
    `create_time` timestamp,
    `update_time` timestamp,
    primary key (`id`)
) engine = innodb default charset = utf8mb4;

drop table if exists `imooc_mall_category`;
create table `imooc_mall_category` (
       `id` int not null  ,
       `name` varchar(32),
       `type` int ,
       `parent_id` int ,
       `oder_num` int,
       `create_time` timestamp,
       `update_time` timestamp
) engine = innodb default charset = utf8mb4;

drop table if exists `imooc_mall_order`;
create table `imooc_mall_order` (
                                       `id` int not null  ,
                                       `order_no` varchar(128),
                                       `user_id` int ,
                                       `total_price` int ,
                                       `receiver_name` varchar(32),
                                       `receiver_mobile` varchar(32),
                                       `receiver_address` varchar(128),
                                       `order_status` int,
                                       `postage` int,
                                       `payment_type` int,
                                       `delivery_time` timestamp,
                                       `pay_time` timestamp,
                                       `end_time` timestamp,
                                       `create_time` timestamp,
                                       `update_time` timestamp,
                                        primary key (`id`)
) engine = innodb default charset = utf8mb4;

drop table if exists `imooc_mall_order_item`;
create table `imooc_mall_order_item` (
                                       `id` int not null  ,
                                       `order_no` varchar(128),
                                       `product_id` int ,
                                       `product_name` varchar(100) ,
                                       `product_img` varchar(128),
                                       `unit_price` int,
                                       `quantity` int,
                                       `total_price` int,
                                       `create_time` timestamp,
                                       `update_time` timestamp,
                                       primary key (`id`)
) engine = innodb default charset = utf8mb4;

drop table if exists `imooc_mall_product`;
create table `imooc_mall_product` (
                                         `id` int not null  ,
                                         `name` varchar(100),
                                         `image` varchar(500) ,
                                         `detail` varchar(500) ,
                                         `category_id` int,
                                         `price` int,
                                         `stock` int,
                                         `status` int,
                                         `create_time` timestamp,
                                         `update_time` timestamp,
                                         primary key (`id`)
) engine = innodb default charset = utf8mb4;

drop table if exists `imooc_mall_user`;
create table `imooc_mall_user` (
                                      `id` int not null  ,
                                      `username` varchar(32),
                                      `password` varchar(50) ,
                                      `personalized_signature` varchar(50) ,
                                      `role` int,
                                      `create_time` timestamp,
                                      `update_time` timestamp,
                                      primary key (`id`)
) engine = innodb default charset = utf8mb4;