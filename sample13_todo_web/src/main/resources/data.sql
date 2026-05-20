replace into todo (id, userid, description, target_date, done)
values (1000, 'kim1225', 'Learn Spring', DATE_ADD(NOW() , Interval 1 YEAR), false),
        (1001, 'park4872', 'Learn SQL', DATE_ADD(NOW() , Interval 1 MONTH), false),
        (1002, 'choi0516', 'Learn k8s', DATE_ADD(NOW() , Interval 20 DAY), false);

replace into member (userid, password, username, role)
values ('kim1225', 'ps2233', '김김김' , 'ADMIN'),
        ('park4872', 'ps4657', '박박박' , 'USER'),
        ('choi0516', 'ps9873', '최최최' , 'USER');