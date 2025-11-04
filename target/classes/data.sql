insert into place(id, name, city) values (1,'銀座の抹茶カフェ','Tokyo');
insert into place(id, name, city) values (2,'京都ラーメン','Kyoto');
insert into review(id, title, category, rating, content, image_url, created_at, place_id)
values (1,'銀座の静かな抹茶カフェ','CAFE',5,'雰囲気がとても落ち着く抹茶カフェ。おすすめ。', 'https://images.unsplash.com/photo-1511920170033-f8396924c348', now(), 1);
insert into review(id, title, category, rating, content, image_url, created_at, place_id)
values (2,'京都の絶品豚骨ラーメン','FOOD',5,'今まで食べた中で最高の豚骨ラーメン。', 'https://images.unsplash.com/photo-1543353071-084e7b9b8262', now(), 2);
