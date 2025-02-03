DROP procedure IF EXISTS `selectCarByRegNumber`;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `selectCarByRegNumber`(IN regPar varchar(7))
BEGIN
SELECT carID,reg
FROM car
WHERE reg = regPar;
END$$
DELIMITER ;
;