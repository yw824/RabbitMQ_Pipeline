# 기본 이미지로 RabbitMQ 공식 이미지 사용
FROM rabbitmq:3.10.5-management

# 필요한 환경 변수 설정
ENV RABBITMQ_DEFAULT_USER=guest
ENV RABBITMQ_DEFAULT_PASS=guest
ENV RABBITMQ_DEFAULT_VHOST=localhost

# 필요한 플러그인 설치 (예: rabbitmq_management)
RUN rabbitmq-plugins enable --offline rabbitmq_management

# 포트 설정
EXPOSE 5672 15672

# RabbitMQ 서버 시작
CMD ["rabbitmq-server"]