FROM postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD pgadmin
ENV POSTGRES_DB MusicApp
COPY create.sql /docker-entrypoint-initdb.d/
COPY insert.sql /docker-entrypoint-initdb.d/
