import {Component, OnInit} from "@angular/core";
import {FormBuilder, FormGroup} from "@angular/forms";
import {VisitorDtoData} from "../../shared/data/visitor-dto.data";
import {VisitorService} from "../../shared/visitor-service";

@Component({
  selector: 'visitor',
  templateUrl: './visitor.component.html',
  providers : [FormBuilder,VisitorService]
})
export class VisitorComponent implements OnInit{

  constructor(private formBuilder : FormBuilder ,private visitorService :VisitorService) { }
  ngOnInit() {}
  formData : FormGroup = this.formBuilder.group({
    name :null,
    id :null,
    relation :null
  });
  add():void{
    let visitorData :VisitorDtoData=new VisitorDtoData() ;
    visitorData.name=this.formData.get("name").value;
    visitorData.relation=this.formData.get("relation").value;
    visitorData.id=this.formData.get("id").value;
    this.visitorService.add(visitorData);
  }

  clear():void { this.formData.reset(); }


}
