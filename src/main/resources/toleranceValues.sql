create table addition_for_hole_over_symbol_h
(
    id                    int auto_increment
        primary key,
    `lower_dimension[mm]` int  null,
    IT3                   int null,
    IT4                   int null,
    IT5                   int null,
    IT6                   int null,
    IT7                   int null,
    IT8                   int null
);

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (1, 3, '1', '1', '1', '3', '4', '6');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (2, 6, '1', '1', '2', '3', '6', '7');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (3, 10, '1', '2', '3', '3', '7', '9');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (4, 18, '1', '2', '3', '4', '8', '12');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (5, 30, '1', '3', '4', '5', '9', '14');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (6, 50, '2', '3', '5', '6', '11', '16');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (7, 80, '2', '4', '5', '7', '13', '19');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (8, 120, '3', '4', '6', '7', '15', '23');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (9, 180, '3', '4', '6', '9', '17', '26');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (10, 250, '4', '4', '7', '9', '20', '29');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (11, 315, '4', '5', '7', '11', '21', '32');

INSERT INTO tolerancevalue.addition_for_hole_over_symbol_h (id, `lower_dimension[mm]`, IT3, IT4, IT5, IT6, IT7, IT8) VALUES (12, 400, '5', '5', '7', '13', '23', '34');


create table basic_deviations_for_hole_over_symbol_h
(
    id                    int auto_increment
        primary key,
    `lower_dimension[mm]` int null,
    J                     int null,
    K                     int null,
    M                     int null,
    N                     int null,
    P                     int null,
    R                     int null,
    S                     int null
);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (1, 0, 6, 0, -2, -4, -6, -10, -14);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (2, 3, 10, -1, -4, -8, -12, -15, -19);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (3, 6, 12, -1, -6, -10, -15, -19, -23);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (4, 10, 15, -1, -7, -12, -18, -23, -28);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (5, 18, 20, -2, -8, -15, -22, -28, -35);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (6, 30, 24, -2, -9, -17, -26, -34, -43);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (7, 40, 24, -2, -9, -17, -26, -34, -43);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (8, 50, 28, -2, -11, -20, -32, -41, -53);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (9, 65, 28, -2, -11, -20, -32, -43, -59);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (10, 80, 34, -3, -13, -23, -37, -51, -71);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (11, 100, 34, -3, -13, -23, -37, -54, -79);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (12, 120, 41, -3, -15, -27, -43, -63, -92);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (13, 140, 41, -3, -15, -27, -43, -65, -100);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (14, 200, 47, -4, -17, -31, -50, -80, -130);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (15, 225, 47, -4, -17, -31, -50, -84, -140);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (16, 250, 55, -4, -20, -34, -56, -94, -158);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (17, 280, 55, -4, -20, -34, -56, -98, -170);

INSERT INTO tolerancevalue.basic_deviations_for_hole_over_symbol_h (id, `lower_dimension[mm]`, J, K, M, N, P, R, S) VALUES (18, 315, 60, -4, -21, -37, -62, -108, -190);


create table basic_deviations_for_hole_under_symbol_h
(
    id                    int auto_increment
        primary key,
    `lower_dimension[mm]` int null,
    A                     int null,
    C                     int null,
    D                     int null,
    E                     int null,
    F                     int null,
    G                     int null,
    H                     int null
);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (1, 0, 270, 60, 20, 14, 6, 2, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (2, 3, 270, 70, 30, 20, 10, 4, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (3, 6, 280, 80, 40, 25, 13, 5, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (4, 10, 290, 95, 50, 32, 16, 6, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (5, 18, 300, 110, 65, 40, 20, 7, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (6, 30, 310, 120, 80, 50, 25, 9, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (7, 40, 320, 130, 80, 50, 25, 9, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (8, 50, 340, 140, 100, 60, 30, 10, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (9, 65, 360, 150, 100, 60, 30, 10, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (10, 80, 380, 170, 120, 72, 36, 12, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (11, 100, 410, 180, 120, 72, 36, 12, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (12, 120, 460, 200, 145, 85, 43, 14, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (13, 140, 520, 210, 145, 85, 43, 14, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (14, 160, 580, 230, 145, 85, 43, 14, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (15, 180, 660, 240, 170, 100, 50, 15, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (16, 200, 740, 260, 170, 100, 50, 15, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (17, 225, 820, 280, 170, 100, 50, 15, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (18, 250, 920, 300, 190, 110, 56, 17, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (19, 280, 1050, 330, 190, 110, 56, 17, 0);

INSERT INTO tolerancevalue.basic_deviations_for_hole_under_symbol_h (id, `lower_dimension[mm]`, A, C, D, E, F, G, H) VALUES (20, 315, 1200, 360, 210, 125, 62, 18, 0);


create table basic_deviations_for_shaft_over_symbol_h
(
    id                    int auto_increment
        primary key,
    `lower_dimension[mm]` int null,
    j                     int null,
    k                     int null,
    m                     int null,
    n                     int null,
    p                     int null,
    r                     int null,
    s                     int null
);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (1, 0, -4, 0, 2, 4, 6, 10, 14);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (2, 3, -4, 1, 4, 8, 12, 15, 19);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (3, 6, -5, 1, 6, 10, 15, 19, 23);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (4, 10, -6, 1, 7, 12, 18, 23, 28);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (5, 18, -8, 2, 8, 15, 22, 28, 35);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (6, 30, -10, 2, 9, 17, 26, 34, 43);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (7, 40, -10, 2, 9, 17, 26, 34, 43);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (8, 50, -12, 2, 11, 20, 32, 41, 53);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (9, 65, -12, 2, 11, 20, 32, 43, 59);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (10, 80, -15, 3, 13, 23, 37, 51, 71);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (11, 100, -15, 3, 13, 23, 37, 54, 79);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (12, 120, -18, 3, 15, 27, 43, 63, 92);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (13, 140, -18, 3, 15, 27, 43, 65, 100);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (14, 160, -18, 3, 15, 27, 43, 68, 108);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (15, 180, -21, 4, 17, 31, 50, 77, 122);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (16, 200, -21, 4, 17, 31, 50, 80, 130);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (17, 225, -21, 4, 17, 31, 50, 84, 140);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (18, 250, -26, 4, 20, 34, 56, 94, 158);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_over_symbol_h (id, `lower_dimension[mm]`, j, k, m, n, p, r, s) VALUES (19, 280, -26, 4, 20, 34, 56, 98, 170);


create table basic_deviations_for_shaft_under_symbol_h
(
    id                    int auto_increment
        primary key,
    `lower_dimension[mm]` int null,
    a                     int null,
    c                     int null,
    d                     int null,
    e                     int null,
    f                     int null,
    g                     int null,
    h                     int null
);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (1, 0, -270, -60, -20, -14, -6, -2, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (2, 3, -270, -70, -30, -20, -10, -4, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (3, 6, -280, -80, -40, -25, -13, -5, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (4, 10, -290, -95, -50, -32, -16, -6, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (5, 18, -300, -110, -65, -40, -20, -7, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (6, 30, -310, -120, -80, -50, -25, -9, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (7, 40, -320, -130, -80, -50, -25, -9, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (8, 50, -340, -140, -100, -60, -30, -10, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (9, 65, -360, -150, -100, -60, -30, -10, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (10, 80, -380, -170, -120, -72, -36, -12, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (11, 100, -410, -180, -120, -72, -36, -12, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (12, 120, -460, -200, -145, -85, -43, -14, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (13, 140, -520, -210, -145, -85, -43, -14, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (14, 160, -580, -230, -145, -85, -43, -14, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (15, 180, -660, -240, -170, -100, -50, -15, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (16, 200, -740, -260, -170, -100, -50, -15, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (18, 225, -820, -280, -170, -100, -50, -15, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (19, 250, -920, -300, -190, -110, -56, -17, 0);

INSERT INTO tolerancevalue.basic_deviations_for_shaft_under_symbol_h (id, `lower_dimension[mm]`, a, c, d, e, f, g, h) VALUES (20, 280, -1050, -330, -190, -110, -56, -17, 0);


create table nominal_tolerance
(
    id                    int auto_increment,
    `lower_dimension[mm]` int    not null,
    `IT1[um]`             double null,
    `IT2[um]`             double null,
    `IT3[um]`             double null,
    `IT4[um]`             double null,
    `IT5[um]`             double null,
    `IT6[um]`             double null,
    `IT7[um]`             double null,
    `IT8[um]`             double null,
    `IT9[um]`             double null,
    `IT10[um]`            double null,
    `IT11[um]`            double null,
    constraint id
        unique (id)
);

alter table nominal_tolerance
    add primary key (id);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (1, 0, 0.8, 1.2, 2, 3, 4, 6, 10, 14, 25, 40, 60);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (2, 3, 1, 1.5, 2.5, 4, 5, 8, 12, 18, 30, 48, 75);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (3, 6, 1, 1.5, 2.5, 4, 6, 9, 15, 22, 36, 58, 90);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (4, 10, 1.2, 2, 3, 5, 8, 11, 18, 27, 43, 70, 110);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (5, 18, 1.5, 2.5, 4, 6, 9, 13, 21, 33, 52, 84, 130);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (6, 30, 1.5, 2.5, 4, 7, 11, 16, 25, 39, 62, 100, 160);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (7, 50, 2, 3, 5, 8, 13, 19, 30, 46, 74, 120, 190);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (8, 80, 2.5, 4, 6, 10, 15, 22, 35, 54, 87, 140, 220);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (9, 120, 3.5, 5, 8, 12, 18, 25, 40, 63, 100, 160, 250);

INSERT INTO tolerancevalue.nominal_tolerance (id, `lower_dimension[mm]`, `IT1[um]`, `IT2[um]`, `IT3[um]`, `IT4[um]`, `IT5[um]`, `IT6[um]`, `IT7[um]`, `IT8[um]`, `IT9[um]`, `IT10[um]`, `IT11[um]`) VALUES (10, 250, 6, 8, 12, 16, 23, 32, 52, 81, 130, 210, 320);
