
INSERT INTO `tylermastproject1db`.`warehouses` (`w_id`, `country`, `capacity`, `city`, `w_name`) VALUES ('1', 'Germany', '100', 'Munich', 'Bear Haus');
INSERT INTO `tylermastproject1db`.`warehouses` (`w_id`, `country`, `capacity`, `city`, `w_name`) VALUES ('2', 'USA', '150', 'Anchorage', 'Grizzly Falls');
INSERT INTO `tylermastproject1db`.`warehouses` (`w_id`, `country`, `capacity`, `city`, `w_name`) VALUES ('3', 'Australia', '200', 'Melbourne', 'Koala Koast');

INSERT INTO `tylermastproject1db`.`product` (`p_id`, `p_name`, `description`, `imageurl`) VALUES ('1', 'Mr. Grizz', 'Mr. Grizz the grizzly bear is ready for that promotion!', 'https://www.vermontteddybear.com/dw/image/v2/BDKM_PRD/on/demandware.static/-/Sites-master-catalog-vtb/default/dw633627ba/images/VTB/vtb-kt00681-15inchbusinesspersonbear-blacksuit-redtie-h_20220513_1455.jpg?sw=600');
INSERT INTO `tylermastproject1db`.`product` (`p_id`, `p_name`, `description`, `imageurl`) VALUES ('2', 'Chef Buzzington', 'Chef Buzzington the honey bear is all ready for make his friends some snacks!', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAGjHT7AMLAj7Tu7fogf2HM6e1CpuQsvtWKw&usqp=CAU');
INSERT INTO `tylermastproject1db`.`product` (`p_id`, `p_name`, `description`, `imageurl`) VALUES ('3', 'Kung Fu Kai', 'Kai the Koala bear is getting ready to go to kung fu practice!', 'https://i.ebayimg.com/images/g/O7YAAOSw7Rthh37T/s-l1200.webp');
INSERT INTO `tylermastproject1db`.`product` (`p_id`, `p_name`, `description`, `imageurl`) VALUES ('4', 'TEST', 'SHOWS WHAT BAD URL LOOKS LIKE', 'badURL');


INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('1', '1', '15');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('2', '1', '25');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('3', '1', '30');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('1', '2', '30');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('2', '2', '40');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('3', '2', '50');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('1', '3', '45');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('2', '3', '46');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('3', '3', '47');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('4', '1', '1');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('4', '2', '1');
INSERT INTO `tylermastproject1db`.`inventory` (`p_id`, `w_id`, `stock`) VALUES ('4', '3', '1');
