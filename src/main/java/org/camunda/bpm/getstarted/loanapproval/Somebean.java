package org.camunda.bpm.getstarted.loanapproval;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.context.DelegateExecutionContext;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component(value="Somebean")
@Slf4j
public class Somebean {

    public void getSignalName() {
//          This works for a signal event but:
//             1. Is not necessary for most task types.
//             2. Is a questionable implementation per the customers comment about how or when the size of the array might be greater than 1.
//        Objects.requireNonNull(
//        ((ExecutionEntity)DelegateExecutionContext.getCurrentDelegationExecution()).getExecutions().get(0).getActivityId()
//        );

//          This demonstrates the customers preferred implementation and its issue for a signal event, other event types not tested.
//        Objects.requireNonNull(
                String activityId = DelegateExecutionContext.getCurrentDelegationExecution().getCurrentActivityId();
                log.info("activityId = {} ", activityId);
//        );
    }
//         This works, but in the customer's implementation it is preferred to not pass an argument to a bean, see JIRA ticket for reasons
//    public void getSignalName(ExecutionEntity executionEntity) {
//
//               log.info("executionEntity.getActivityId() = {} ", executionEntity.getActivityId());
//
//    }
}
