create database `mini-commerce`;

create table user (
                      user_no int auto_increment comment '사용자 SEQ' primary key ,
                      id varchar(100) not null comment '사용자 아이디',
                      name varchar(200) not null comment '사용자 명',
                      del_yn varchar(2) not null default 'N' comment '삭제 여부'
) comment '사용자'
;

create table product (
                         product_no int auto_increment comment '상품 SEQ' primary key ,
                         code varchar(100) not null comment '상품 코드',
                         name varchar(200) not null comment '상품 명',
                         price long not null comment '상품 가격',
                         expose_yn varchar(2) not null default 'Y' comment '노출 여부',
                         del_yn varchar(2) not null default 'N' comment '삭제 여부'
) comment '상품'
;

create table product_stock (
                               product_no int comment '상품 SEQ' primary key ,
                               stock_cnt int comment '재고 수량',
                               foreign key (product_no) references product (product_no)
) comment '상품 재고'
;

create table order_his (
                           order_no int auto_increment comment '주문 SEQ' primary key ,
                           product_no int not null comment '상품 SEQ' ,
                           user_no int not null comment '사용자 SEQ',
                           product_cnt int comment '상품 수량',
                           tot_price BIGINT comment '총 결제 가격',
                           order_status varchar(10) comment '주문 상태(PAY, CANCEL)',
                           reg_dt datetime default now() comment '등록 일시',
                           mod_dt datetime comment '수정 일시',
                           foreign key (user_no) references user(user_no),
                           foreign key (product_no) references product(product_no)
) comment '주문'
;