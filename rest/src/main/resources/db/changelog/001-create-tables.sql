
    create table lighting (
        id bigint identity not null,
        aliases varbinary(255),
        bcmPin smallint not null,
        description varchar(70),
        lastUpdated bigint,
        lastUpdatedBy varchar(30),
        name varchar(20) not null,
        ranking smallint not null,
        raspberryPin smallint not null,
        state smallint check (state between 0 and 1),
        wireHexColor varchar(7) not null,
        wiringPiPin smallint not null,
        primary key (id)
    );

    alter table lighting 
       add constraint UK_dsh2vod22yhjqvi0us44luddh unique (name);
