CREATE TABLE game (
    game_id text,
    expansion text,
    name text,
    owner text,
    PRIMARY KEY (game_id)
);

CREATE TABLE player (
    game_id text,
    player_id text,
    PRIMARY KEY (game_id, player_id)
);

CREATE TABLE nickname (
    player_id text,
    name text,
    PRIMARY KEY (player_id)
);

CREATE TABLE tile (
    game_id text,
    col integer,
    row integer,
    resource text,
    number_token integer,
    PRIMARY KEY (game_id, col, row)
);

CREATE TABLE road (
    game_id text,
    col integer,
    row integer,
    dir text,
    owner text,
    PRIMARY KEY (game_id, col, row, dir)
);

CREATE TABLE settlement (
    game_id text,
    col integer,
    row integer,
    dir text,
    owner text,
    is_upgraded boolean,
    PRIMARY KEY (game_id, col, row, dir)
);