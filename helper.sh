#!/bin/bash


# Check if argument is provided
if [ $# -eq 0 ]; then
    echo "Usage: $0 <entity_name>"
    exit 1
fi

entity_name=$1
project_structure=/home/shuvo/Desktop/code/java/jwtAuthPondit/src/main/java/com/enummitanno/jwtauthpondit
project_structure_package=com.enummitanno.jwtauthpondit

# Create directories if not exist
mkdir -p "$project_structure/controller"
mkdir -p "$project_structure/model"
mkdir -p "$project_structure/service"
mkdir -p "$project_structure/repository"
mkdir -p "$project_structure/dto"

# Generate Controller
controller_path="${project_structure}/controller/${entity_name}Controller.java"
echo "package ${project_structure_package}.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(\"/${entity_name}\")
public class ${entity_name}Controller {

    // Add your controller methods here

    @GetMapping({\"/\", \"\"})
    public ResponseEntity<?> index() {

      return ResponseEntity.ok(new Object(){
          public final String status = \"success\";
      });
    }

    @GetMapping({\"/{id}\", \"{id}\"})
    public ResponseEntity<?> show(@PathVariable(name = \"id\") Long id) {

      return ResponseEntity.ok(new Object(){
          public final String status = \"success\";
      });
    }

    @PostMapping({\"/create\", \"create\"})
    public ResponseEntity<?> show() {

      return ResponseEntity.ok(new Object(){
          public final String status = \"success\";
      });
    }

    @PostMapping({\"/update/{id}\", \"update/{id}\"})
    public ResponseEntity<?> update(@PathVariable(name = \"id\") Long id) {

      return ResponseEntity.ok(new Object(){
          public final String status = \"success\";
      });
    }

    @PostMapping({\"/delete/{id}\", \"delete/{id}\"})
    public ResponseEntity<?> update(@PathVariable(name = \"id\") Long id) {

      return ResponseEntity.ok(new Object(){
          public final String status = \"success\";
      });
    }

}" > "$controller_path"

echo "Generated $controller_path"

# Generate Model
model_path="${project_structure}/model/${entity_name}.java"
plural_entity_name=$(echo "$entity_name" | sed 's/.*\///; s/^\(.\)/\L\1/; s/\(.\)Controller$/\1s/')

echo "package ${project_structure_package}.model;

import jakarta.persistence.*;

@Entity
@Table(name = \"${plural_entity_name}s\")
@Data
public class ${entity_name} {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add your entity attributes here

    // Add getters and setters



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = \"created_at\", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = \"updated_at\", nullable = true)
    private Date updatedAt;

}" > "$model_path"

echo "Generated $model_path"

# Generate Service
service_path="${project_structure}/service/${entity_name}Service.java"
echo "package ${project_structure_package}.service;

import org.springframework.stereotype.Service;

@Service
public class ${entity_name}Service {

    // Add your service methods here

}" > "$service_path"

echo "Generated $service_path"


######################################################################
#################### Generate Repository #############################
######################################################################
repository_path="${project_structure}/repository/${entity_name}Repository.java"
echo "package ${project_structure_package}.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ${project_structure_package}.model.${entity_name};

public interface ${entity_name}Repository extends JpaRepository<${entity_name}, Long> {

}" > "$repository_path"

echo "Generated $repository_path"

echo "Boilerplate code generated for $entity_name: Controller, Model, Service, Repository"



######################################################################
####################### Generate DTO #################################
######################################################################
create_dto_path="${project_structure}/dto/Create${entity_name}DTO.java"
update_dto_path="${project_structure}/dto/Update${entity_name}DTO.java"
echo "package ${project_structure_package}.dto;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Create${entity_name}DTO {

    // Add your service methods here

}" > "$create_dto_path";

echo "package ${project_structure_package}.dto;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Update${entity_name}DTO {

    // Add your service methods here

}" > "$update_dto_path";


echo "Generated $update_dto_path"



# Set permissions to make the files writable
sudo chmod 777 "$controller_path" "$model_path" "$service_path" "$repository_path" "$create_dto_path" "$update_dto_path"
sudo chmod -R 777 .
