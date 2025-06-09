rootProject.name = "multimodule-bolilerplate"

include(":web-api", ":search-api", ":event-processor")
include(":repository-jpa", ":repository", ":queue", ":redis-queue")
include(":model")
include(":constant", ":exceptions", ":logging", ":monitoring")
include(":crud-controller", ":search-controller")

project(":web-api").projectDir = file("modules/applications/web-api")
project(":search-api").projectDir = file("modules/applications/search-api")
project(":event-processor").projectDir = file("modules/applications/event-processor")

project(":repository-jpa").projectDir = file("modules/infra/repository-jpa")
project(":repository").projectDir = file("modules/infra/repository")
project(":queue").projectDir = file("modules/infra/queue")
project(":redis-queue").projectDir = file("modules/infra/redis-queue")

project(":model").projectDir = file("modules/model/model")

project(":constant").projectDir = file("modules/common/constant")
project(":exceptions").projectDir = file("modules/common/exceptions")
project(":logging").projectDir = file("modules/common/logging")
project(":monitoring").projectDir = file("modules/common/monitoring")

project(":crud-controller").projectDir = file("modules/controllers/crud-controller")
project(":search-controller").projectDir = file("modules/controllers/search-controller")