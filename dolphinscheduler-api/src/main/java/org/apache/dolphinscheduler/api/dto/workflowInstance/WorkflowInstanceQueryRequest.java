/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.api.dto.workflowInstance;

import org.apache.dolphinscheduler.api.dto.PageQueryDto;
import org.apache.dolphinscheduler.dao.entity.WorkflowInstance;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * workflow instance request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class WorkflowInstanceQueryRequest extends PageQueryDto {

    @Schema(name = "projectName", example = "PROJECT-NAME")
    String projectName;

    @Schema(name = "workflowName", example = "WORKFLOW-NAME")
    String workflowName;

    @Schema(name = "host", example = "HOST")
    String host;

    @Schema(name = "startDate", example = "START-TIME")
    String startTime;

    @Schema(name = "endDate", example = "END-DATE")
    String endTime;

    @Schema(name = "state", example = "STATE")
    Integer state;

    public WorkflowInstance convert2WorkflowInstance() {
        WorkflowInstance workflowInstance = new WorkflowInstance();
        if (this.workflowName != null) {
            workflowInstance.setName(this.workflowName);
        }
        if (this.host != null) {
            workflowInstance.setHost(this.host);
        }
        return workflowInstance;
    }
}
