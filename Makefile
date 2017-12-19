build:
	mvn clean install

book-store:
	docker build -t sandornemeth/book-store apps/book-store
	docker push sandornemeth/book-store