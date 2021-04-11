run:
	@docker run -p 6379:6379 redis

stop:
	@docker stop redis
