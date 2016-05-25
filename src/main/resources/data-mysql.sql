INSERT INTO author VALUES (NULL, 'kuba', CURRENT_TIMESTAMP());
INSERT INTO author VALUES (NULL, 'kuba2', CURRENT_TIMESTAMP());
INSERT INTO picture VALUES
  (NULL, 'http://www.ovocedoskol.szif.cz/web/getArticleThumb.aspx?aid=112&w=1024', 'svestka', CURRENT_TIMESTAMP(), 5, 4,
   1);
INSERT INTO picture VALUES
  (NULL, 'https://pesbruno.sk/public/data/img/blog/245/pes-jahody.jpg', 'jahoda se psem', CURRENT_TIMESTAMP(), 2, 2, 1);
INSERT INTO picture
VALUES (NULL, 'http://www.inf.sgsp.edu.pl/pub/MALUNKI_DUZE/ROZNE_DUZE/zaba.png', 'zaba', CURRENT_TIMESTAMP(), 3, 1, 1);
INSERT INTO picture VALUES (NULL,
                            'http://previews.123rf.com/images/mumut/mumut1111/mumut111100002/11225683-Cute-cartoon-fruits-Isolated-objects-for-design-element--Stock-Photo.jpg',
                            'fotka', CURRENT_TIMESTAMP(), 30, 20, 1);
INSERT INTO tag VALUES (NULL, 'ovoce');
INSERT INTO tag VALUES (NULL, 'zvirata');
INSERT INTO tag VALUES (NULL, 'zelenina');
INSERT INTO tag VALUES (NULL, 'pejsci');
INSERT INTO picture_has_tag VALUES (1, 1);
INSERT INTO picture_has_tag VALUES (1, 2);
INSERT INTO picture_has_tag VALUES (1, 3);
INSERT INTO picture_has_tag VALUES (2, 1);
INSERT INTO picture_has_tag VALUES (2, 3);
INSERT INTO picture_has_tag VALUES (2, 2);
INSERT INTO picture_has_tag VALUES (2, 4);
INSERT INTO comment VALUES (NULL, 'pekny obrazek', 42, 20, 1, 1);
INSERT INTO comment VALUES (NULL, 'ten se mi libi', 19, 2, 1, 1);
INSERT INTO comment VALUES (NULL, 'je pekny no', 16, 3, 1, 1);
INSERT INTO comment VALUES (NULL, 'taky ujde', 15, 4, 2, 1);
INSERT INTO comment VALUES (NULL, 'ano je opravdu mocc pekny', 100, 50, 2, 1);