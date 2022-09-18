package at.fhtw.swen3.persistence;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * WarehouseAllOf
 */

@JsonTypeName("warehouse_allOf")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-18T08:59:17.579754Z[Etc/UTC]")
public class WarehouseAllOf {

  @JsonProperty("level")
  private Integer level;

  @JsonProperty("nextHops")
  @Valid
  private List<WarehouseNextHops> nextHops = null;

  public WarehouseAllOf level(Integer level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
  */
  
  @Schema(name = "level", required = false)
  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public WarehouseAllOf nextHops(List<WarehouseNextHops> nextHops) {
    this.nextHops = nextHops;
    return this;
  }

  public WarehouseAllOf addNextHopsItem(WarehouseNextHops nextHopsItem) {
    if (this.nextHops == null) {
      this.nextHops = new ArrayList<>();
    }
    this.nextHops.add(nextHopsItem);
    return this;
  }

  /**
   * Next hops after this warehouse (warehouses or trucks).
   * @return nextHops
  */
  @Valid 
  @Schema(name = "nextHops", description = "Next hops after this warehouse (warehouses or trucks).", required = false)
  public List<WarehouseNextHops> getNextHops() {
    return nextHops;
  }

  public void setNextHops(List<WarehouseNextHops> nextHops) {
    this.nextHops = nextHops;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WarehouseAllOf warehouseAllOf = (WarehouseAllOf) o;
    return Objects.equals(this.level, warehouseAllOf.level) &&
        Objects.equals(this.nextHops, warehouseAllOf.nextHops);
  }

  @Override
  public int hashCode() {
    return Objects.hash(level, nextHops);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WarehouseAllOf {\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    nextHops: ").append(toIndentedString(nextHops)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

