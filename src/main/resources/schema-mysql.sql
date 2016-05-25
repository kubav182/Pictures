DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Picture_has_Tag;
DROP TABLE IF EXISTS Picture;
DROP TABLE IF EXISTS Tag;
DROP TABLE IF EXISTS Author;

CREATE TABLE IF NOT EXISTS `Author` (
  `id`                INT          NOT NULL AUTO_INCREMENT,
  `name`              VARCHAR(100) NOT NULL,
  `registration_date` DATETIME     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Picture` (
  `id`          INT          NOT NULL AUTO_INCREMENT,
  `url`         VARCHAR(200) NOT NULL,
  `name`        VARCHAR(100) NOT NULL,
  `last_update` DATETIME     NOT NULL,
  `likes`       INT          NOT NULL DEFAULT 0,
  `dislikes`    INT          NOT NULL DEFAULT 0,
  `Author_id`   INT          NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Picture_Author1_idx` (`Author_id` ASC),
  CONSTRAINT `fk_Picture_Author1`
  FOREIGN KEY (`Author_id`)
  REFERENCES `Author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Tag` (
  `id`   INT         NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Comment` (
  `id`         INT          NOT NULL AUTO_INCREMENT,
  `comment`    VARCHAR(100) NOT NULL,
  `likes`      INT          NOT NULL DEFAULT 0,
  `dislikes`   INT          NOT NULL DEFAULT 0,
  `Picture_id` INT          NOT NULL,
  `Author_id`  INT          NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Comment_Picture1_idx` (`Picture_id` ASC),
  INDEX `fk_Comment_Author1_idx` (`Author_id` ASC),
  CONSTRAINT `fk_Comment_Picture1`
  FOREIGN KEY (`Picture_id`)
  REFERENCES `Picture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Author1`
  FOREIGN KEY (`Author_id`)
  REFERENCES `Author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `Picture_has_Tag` (
  `Picture_id` INT NOT NULL,
  `Tag_id`     INT NOT NULL,
  PRIMARY KEY (`Picture_id`, `Tag_id`),
  INDEX `fk_Picture_has_Tag_Tag1_idx` (`Tag_id` ASC),
  INDEX `fk_Picture_has_Tag_Picture_idx` (`Picture_id` ASC),
  CONSTRAINT `fk_Picture_has_Tag_Picture`
  FOREIGN KEY (`Picture_id`)
  REFERENCES `Picture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Picture_has_Tag_Tag1`
  FOREIGN KEY (`Tag_id`)
  REFERENCES `Tag` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;