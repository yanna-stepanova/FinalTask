CREATE TABLE Accounts (
    acct_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    acct_money DOUBLE(8 , 2 ),
    acct_date DATE,
    PRIMARY KEY (acct_id , user_id),
    FOREIGN KEY (user_id)
        REFERENCES users (user_id)
);

create table Users(
user_id bigint not null auto_increment,
user_name varchar(50) not null,
acct_id bigint,
primary key(user_id),
foreign key(acct_id) references accouts(acct_id)
 );