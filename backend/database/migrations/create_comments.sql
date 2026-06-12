DROP TABLE IF EXISTS comments;

CREATE TABLE comments(
    comment_id UUID PRIMARY KEY,
    content TEXT NOT NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP NOT NULL
);