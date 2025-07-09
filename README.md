# 微服务

## 项目介绍
本智云平台是一个基于微服务架构的云平台系统，提供了丰富的云服务功能。

## 技术栈

### 基础框架
- **Java 17**: 作为主要开发语言
- **Spring Boot 3.3.4**: 微服务基础框架
- **Spring Cloud 2023.0.3**: 微服务生态
- **Spring Cloud Alibaba 2023.0.3.2**: 阿里巴巴微服务生态

### 微服务组件
- **Nacos**: 服务注册发现和配置中心，实现服务治理和动态配置管理
- **OpenFeign**: 声明式服务调用框架，简化服务间通信
- **Sentinel**: 流量控制和熔断降级框架，保障系统稳定性
- **Gateway**: 基于Spring Cloud Gateway的统一网关服务
- **Spring Cloud LoadBalancer**: 负载均衡组件

### 构建工具
- **Maven**: 依赖管理和项目构建

### 开发工具
- **Lombok**: 简化Java代码编写

## 项目结构
```
benzhi-cloud/
│
├── gateway/               # 网关服务
│   ├── src/               # 源代码
│   │   ├── main/          # 主要代码
│   │   │   ├── java/      # Java代码
│   │   │   └── resources/ # 配置文件
│   │   └── test/          # 测试代码
│   └── pom.xml            # Maven配置
│
├── services/              # 微服务集合
│   ├── service-test/      # 测试服务示例
│   │   ├── src/           # 源代码
│   │   └── pom.xml        # Maven配置
│   └── pom.xml            # 服务父模块Maven配置
│
├── model/                 # 公共模型模块
│   ├── src/               # 源代码
│   └── pom.xml            # Maven配置
│
└── pom.xml                # 项目根Maven配置
```

## 代码规范

### 项目结构规范
1. **模块化设计**:
   - `gateway`: 统一的API网关服务
   - `services`: 所有微服务模块的集合
   - `model`: 公共数据模型和工具类

2. **服务命名规范**:
   - 所有服务模块以"service-xxx"方式命名，例如`service-test`

### 包结构规范
每个服务模块内部包结构建议如下：
```
com.benzhi.服务名称/
├── config/         # 配置类
├── controller/     # 控制器
├── service/        # 服务接口和实现
│   └── impl/       # 服务实现类
├── mapper/         # 数据访问层
├── entity/         # 实体类
├── dto/            # 数据传输对象
├── vo/             # 视图对象
├── util/           # 工具类
├── feign/          # Feign客户端
│   └── fallback/   # Feign客户端的兜底回调
└── Application.java # 启动类
```

### 编码规范
1. **命名规范**:
   - 类名: 驼峰式命名，首字母大写
   - 方法名: 驼峰式命名，首字母小写
   - 变量: 驼峰式命名，首字母小写
   - 常量: 全大写，单词间用下划线分隔

2. **注释规范**:
   - 类注释: 描述类的功能和用途
   - 方法注释: 描述方法的功能、参数和返回值
   - 复杂逻辑需要添加行内注释

### 微服务组件使用规范

1. **Nacos使用规范**:
   - 服务注册采用服务名+环境标识的命名方式，如`service-test-dev`
   - 配置文件统一按照`应用名-环境.yaml`格式命名，如`service-test-dev.yaml`
   - 共享配置使用`common-配置类型.yaml`格式，如`common-redis.yaml`
   - 重要配置需添加备注说明
   - 敏感信息需使用加密配置

2. **OpenFeign使用规范**:
   - Feign接口统一放置在`feign`包中
   - 接口命名使用`服务名称Client`格式，如`TestServiceClient`
   - 如须配置降级处理，降级类放在`feign/fallback`包中
   - 接口方法需与服务提供方保持一致，并添加完整注释

3. **Sentinel使用规范**:
   - 如需降级，降级方法应在同一类中实现，并通过`blockHandler`指定
   - 业务异常与熔断降级异常分开处理

4. **Gateway规范**:
   - 路由配置集中管理，按照服务分组
   - 必要的请求需增加日志记录
   - 全局过滤器需实现对请求的基础校验


## 开发流程
1. 基于Maven多模块架构进行开发
2. 遵循微服务设计原则，保持服务间低耦合
3. 通过网关统一管理和路由所有服务API
4. 使用Nacos进行服务注册和配置管理
5. 通过OpenFeign实现服务间调用
6. 使用Sentinel实现服务保护和限流降级

## 部署说明
项目支持Docker容器化部署，各服务可独立部署和扩展。服务测试模块提供了`restart-serviceTest.sh`脚本用于服务重启。

## 配置说明
1. **Nacos配置中心**:
   - 地址: `http://nacos-server:8848/nacos`
   - 命名空间按环境划分: dev, test, prod
   - 配置格式优先使用YAML

2. **监控告警**:
   - Sentinel Dashboard: `http://sentinel-dashboard:8080`
   - 服务健康检查周期: 30s

## 版本控制
使用Git进行版本控制，遵循标准Git工作流。 